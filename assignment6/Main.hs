{-# LANGUAGE OverloadedStrings #-}
{-# LANGUAGE DeriveGeneric #-}

import Web.Scotty
import Data.Aeson (FromJSON, ToJSON, object, (.=))
import GHC.Generics (Generic)
import Data.Maybe (fromMaybe)

-- -----------------------------------------------------------------------------
-- LOGIC
-- -----------------------------------------------------------------------------

isSorted :: [Int] -> Bool
isSorted [] = True
isSorted [a] = True
isSorted (a:b:rest) = 
    if a <= b 
    then isSorted (b:rest)
    else False

sumList :: [Int] -> [Int] -> [Int] -> [Int]
sumList list0 list1 list2 = 
    zipWith3 (\ a b c -> a + b + c) list0 list1 list2

setHead :: [Int] -> Int -> [Int]
setHead list element = 
    element : list

append :: [Int] -> Int -> Int -> [Int]
append list index element =
    let (first, second) = splitAt index list
    in first ++ [element] ++ second

squareList :: [Int] -> [Int] -> [(Int, Int)]
squareList list0 list1 =
    [ (a*a, b*b) | (a, b) <- zip list0 list1]

-- -----------------------------------------------------------------------------
-- DATA TYPES & HELPERS
-- -----------------------------------------------------------------------------
data AnyReq = AnyReq {
    list    :: Maybe [Int],
    list0   :: Maybe [Int],
    list1   :: Maybe [Int],
    list2   :: Maybe [Int],
    element :: Maybe Int,
    index   :: Maybe Int
} deriving (Show, Generic)

instance FromJSON AnyReq

getList  req = fromMaybe [] (list req)
getList0 req = fromMaybe [] (list0 req)
getList1 req = fromMaybe [] (list1 req)
getList2 req = fromMaybe [] (list2 req)
getElem  req = fromMaybe 0  (element req)
getIndex req = fromMaybe 0  (index req)

-- -----------------------------------------------------------------------------
-- SERVER
-- -----------------------------------------------------------------------------
main :: IO ()
main = scotty 8080 $ do

    -- Handles a JSON request by parsing the body and passing it to a handler function.
    -- The (>>=) operator chains the parsed AnyReq through the handler in the Handler monad.
    -- The handler function f should process AnyReq and return a value that's ToJSON-serializable.
    -- The json function serializes the result and sends it as a JSON response to the client.
    let run route f = post route $ jsonData >>= json . f

    run "/is_sorted" $ \req -> 
        object [ "isSorted result: " .= isSorted (getList req) ]

    run "/sum_list" $ \req -> 
        sumList (getList0 req) (getList1 req) (getList2 req)

    run "/set_head" $ \req -> 
        setHead (getList req) (getElem req)

    run "/append" $ \req -> 
        append (getList req) (getIndex req) (getElem req)

    run "/square_list" $ \req -> 
        squareList (getList0 req) (getList1 req)