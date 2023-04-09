[![Java CI with Maven](https://github.com/crisywini/text-analyzer/actions/workflows/maven.yml/badge.svg)](https://github.com/crisywini/text-analyzer/actions/workflows/maven.yml)


# Text Analyzer

This text analyzer has these functionalities: 

- Count words giving a text
- Extract the sentiment of a given text

## Usage

Download the repo and run the next command in the root folder: 

    mvn spring-boot:run 


Then you can use the localhost:8080/ the exposed services at this moment are:

| Service | Method | Description |
|--|--|--|
| */texts/words* | POST | Counts the total of the words in a given text |
| */texts/group/words* | POST | Counts how many times each word is in a given text |
| */sentiments* | POST | Extract the sentiment of a given text |

### Example:

    curl --location 'localhost:8080/sentiments' \
        --header 'Content-Type: application/json' \
        --data '{
        "text": "I am really happy, I finish my work earlier"
    }'

### Output: 

    {
        "Positive": 3
    }
