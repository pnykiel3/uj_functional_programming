{-# LANGUAGE OverloadedStrings #-}
{-# LANGUAGE DeriveGeneric #-}

import Web.Scotty
import Data.Aeson (FromJSON, ToJSON, object, (.=))
import GHC.Generics (Generic)
import Data.Maybe (fromMaybe)
-- -----------------------------------------------------------------------------
-- LOGIC
-- -----------------------------------------------------------------------------
-- based on linear congruential generator
nextInt :: Int -> Int
nextInt seed =
    let 
    a = 6364136223846793005
    c = 1442695040888963407
    newSeed = a * seed + c
    result = if newSeed < 0 then -(newSeed +1) else newSeed
    in
    result

nextDouble :: Int -> Double
nextDouble seed =
    let
        randomInt = fromIntegral (nextInt seed) :: Double
        maxInt = fromIntegral (maxBound :: Int) :: Double
        result = randomInt / (maxInt + 1.0)
    in result
-- -----------------------------------------------------------------------------
-- DATA TYPES & HELPERS
-- -----------------------------------------------------------------------------
data AnyReq = AnyReq {
    seed    :: Maybe Int
} deriving (Show, Generic)

instance FromJSON AnyReq

getSeed  req = fromMaybe 0 (seed req)
-- -----------------------------------------------------------------------------
-- SERVER
-- -----------------------------------------------------------------------------
main :: IO ()
main = scotty 8080 $ do

    let run route f = post route $ jsonData >>= json . f

    run "/next_int" $ \req -> 
        nextInt (getSeed req)

    run "/next_double" $ \req ->
        nextDouble (getSeed req)