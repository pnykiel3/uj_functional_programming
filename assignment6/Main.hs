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

-- -----------------------------------------------------------------------------
-- DATA TYPES & HELPERS
-- -----------------------------------------------------------------------------
data AnyReq = AnyReq {
    list    :: Maybe [Int]
} deriving (Show, Generic)

instance FromJSON AnyReq

getList  req = fromMaybe [] (list req)

-- -----------------------------------------------------------------------------
-- SERVER
-- -----------------------------------------------------------------------------
main :: IO ()
main = scotty 8080 $ do

    let run route f = post route $ jsonData >>= json . f

    run "/is_sorted" $ \req -> 
        object [ "isSorted result: " .= isSorted (getList req) ]