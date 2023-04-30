[![Java CI with Maven](https://github.com/crisywini/text-analyzer/actions/workflows/maven.yml/badge.svg)](https://github.com/crisywini/text-analyzer/actions/workflows/maven.yml)


# Text Analyzer

This text analyzer has these functionalities: 

- Count words giving a text
- Extract the sentiment of a given text
- Get the most repeated words order by times seen
- Get how many times each word appears in the text

## Usage

Download the repo and run the next command in the root folder: 

    mvn spring-boot:run 


Then you can use the localhost:8080/ the exposed services at this moment are:

| Service | Method | Description |
|--|--|--|
| */texts/words* | POST | Counts the total of the words in a given text |
| */texts/group/words* | POST | Counts how many times each word is in a given text |
| */texts/most-repeated/words* | POST | Get the 10 most repeated words and its concurrency |
| */sentiments* | POST | Extract the sentiment of a given text |


### Example:

    curl --location 'localhost:8080/sentiments' \
        --header 'Content-Type: application/json' \
        --data '{
        "text": "I am really happy, I finish my work earlier"
    }'

### Output: 

    
        Positive
    
#### Additional:

I would like to create an experimental branch and tried to do some experimental features, or maybe the same features like countWords but thinking in different programming paradigms.
