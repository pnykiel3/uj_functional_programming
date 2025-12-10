{-# LANGUAGE OverloadedStrings #-}
{-# LANGUAGE DeriveGeneric #-}

import Web.Scotty
import Data.Aeson (FromJSON, ToJSON, object, (.=))
import GHC.Generics (Generic)
import Data.Maybe (fromMaybe)
-- -----------------------------------------------------------------------------
-- DATA TYPES & HELPERS
-- -----------------------------------------------------------------------------
data AnyReq = AnyReq {
    x    :: Maybe Int,
    y    :: Maybe Int,
    op   :: Maybe Char
} deriving (Show, Generic)

instance FromJSON AnyReq

getX  req = fromMaybe 0 (x req)
getY  req = fromMaybe 0 (y req)
getOp req = fromMaybe '+' (op req)

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