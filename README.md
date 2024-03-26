<h1>Data Enrichment Application</h1>
<h3>Running the application</h3>

First you need to unzip and move the file `interview-test-org.json.gz` from Google Cloud Storage to resources on the path `src/main/resources/interview-test-org.json`

To start the application run the following commands in the project root

> docker compose build

> docker compose up

Data processing will start automatically on start up

To fetch resulting dataset run the following command in your terminal
>curl -X GET http://localhost:8080/api/company

A snapshot of the resulting dataset can be found at `src/main/resources/result.json`

<h3>Future Work</h3>
- Further unit, integration and E2E-testing
- Enhance data quality with data validation
- Handle errors gracefully
- Improve name matching for Company and Organization
- Utilize the other available files in the Google Cloud Storage to get more data on each company