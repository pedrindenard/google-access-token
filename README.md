# OAuth Token Provider

## Description

This repository contains a Kotlin program that allows users to provide an OAuth token for authentication purposes. The program presents a menu with options to select an action: providing the token or exiting the program. If the user chooses to provide the token, the program reads the necessary credentials from a `service-account.json` file, creates an access token using GoogleCredentials, and saves it to a file named `access_token.txt` in the `Downloads` directory. The program then displays the absolute path of the saved file.

## Getting Started

### Prerequisites

To run the program, you need to have Kotlin installed on your machine.

### Installation

1. Clone the repository or download the source code files.
2. Ensure that you have the `service-account.json` credentials file.
3. Place the `service-account.json` file in the `Downloads` directory.
4. Open the code in your preferred Kotlin development environment.

## Usage

1. Build and run the program.
2. You will be presented with a menu.
3. Enter `1` to provide an OAuth token.
4. The program will read the credentials from the `service-account.json` file and create an access token using GoogleCredentials.
5. The access token will be saved to a file named `access_token.txt` in the `Downloads` directory.
6. The program will display the absolute path of the saved file.
7. Repeat the process by selecting `1` or exit the program by entering `2`.

## Dependencies

The program relies on the following dependencies:

- Google Credentials: The program uses the Google Credentials library to read the service account credentials and create an access token.
- Kotlin Standard Library: The standard library for the Kotlin programming language is used for various operations in the program.

## Contributing

Contributions to the project are welcome. If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

## License

The code in this repository is licensed under the MIT License. Feel free to modify and use it according to your needs.
