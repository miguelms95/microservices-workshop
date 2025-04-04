#!/bin/bash

# Check if parameters are provided, set defaults if not
if [ $# -gt 2 ]; then
    echo "Usage: $0 [<number_of_series>] [<port>]"
    exit 1
fi

# Set default values
SERIES=${1:-1}          # Default to 1 series if not provided
PORT=${2:-8080}        # Default to port 8080 if not provided

URLS=(
    "http://localhost:$PORT/user-micro/api/users"
    "http://localhost:$PORT/order-micro/"
    "http://localhost:$PORT/user-micro/api/users/1"
    "http://localhost:$PORT/user-micro/api/users/2"
)

echo "Starting test with $SERIES series on port $PORT"
echo "------------------------"

for ((i=1; i<=SERIES; i++))
do
    # Generate random number between 1 and 15
    RANDOM_COUNT=$(( RANDOM % 15 + 1 ))  # +1 ensures at least 1 request

    echo "Series $i: Making $RANDOM_COUNT random requests"

    for ((j=1; j<=RANDOM_COUNT; j++))
    do
        # Randomly select URL from array
        RANDOM_URL=${URLS[$(( RANDOM % ${#URLS[@]} ))]}

        # Measure time and execute curl
        echo -n "Request $j - "
        curl --location --silent --output /dev/null \
            --write-out 'Status: %{http_code} - Time: %{time_total}s - URL: '"$RANDOM_URL"'\n' \
            "$RANDOM_URL"

        # Wait 0.05 seconds between requests
        sleep 0.05
    done

    echo "Finished series $i"
    echo "------------------------"
    sleep 1
done

echo "Test completed"