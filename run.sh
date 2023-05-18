#!/bin/bash

# Exit on any error
set -e

# Ensure the script is run from the project's root directory
cd "$(dirname "$0")"

# Build the project
bash build.sh

java -jar build/libs/green-code-0.0.1.jar