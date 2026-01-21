{-# LANGUAGE OverloadedStrings #-}
{-# LANGUAGE DeriveGeneric #-}

import Web.Scotty
import Data.Aeson (FromJSON, ToJSON, object, (.=))
import GHC.Generics (Generic)
import Data.Maybe (fromMaybe)
import Control.Monad (join)
-- -----------------------------------------------------------------------------
-- LOGIC
-- -----------------------------------------------------------------------------
sumList :: [Int] -> Int
sumList [] = 0
sumList (x:xs) = x + sumList xs
-- -----------------------------------------------------------------------------
-- DATA TYPES & HELPERS
-- -----------------------------------------------------------------------------
data AnyReq = AnyReq {
    x    :: Maybe Int,
    y    :: Maybe Int,
    op   :: Maybe Char,
    list0   :: Maybe [Int],
    list1   :: Maybe [Int],
    list2   :: Maybe [Int]
} deriving (Show, Generic)

instance FromJSON AnyReq

getX  req = fromMaybe 0 (x req)
getY  req = fromMaybe 0 (y req)
getOp req = fromMaybe '+' (op req)
getList0 req = fromMaybe [] (list0 req)
getList1 req = fromMaybe [] (list1 req)
getList2 req = fromMaybe [] (list2 req)
-- -----------------------------------------------------------------------------
-- SERVER
-- -----------------------------------------------------------------------------
main :: IO ()
main = scotty 8080 $ do

    let run route f = post route $ jsonData >>= json . f

    run "/add_functor" $ \req ->
        let
            xVal = getX req
            yVal = getY req
        in
            if getOp req == '-'
                then fmap (xVal -) (Just yVal)
                else fmap (+ xVal) (Just yVal)

    run "/concat" $ \req ->
        let
            l0 = getList0 req
            l1 = getList1 req
            l2 = getList2 req
        in
            l0 <> l1 <> l2
    
    run "/safe_sum" $ \req ->
        do
            l0 <- list0 req
            if null l0
                then Nothing
                else return $ sumList l0