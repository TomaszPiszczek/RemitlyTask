# RemitlyTask

## Requirements
- Java 21
- Spring Boot 3.2.3

## How to Run
1. Clone this repository to your local machine.
2. Navigate to the project directory.
3. Run the following command to build the project { mvn clean install , mvn spring-boot:run}.
4. The application will start, and you can access it with Postman by sending POST request at http://localhost:8080/api/v1/verifyResources with JSON body defined as AWS::IAM::Role Policy

example body:
```json
{
    "PolicyName": "root",
    "PolicyDocument": {
        "Version": "2012-10-17",
        "Statement": [
            {
                "Sid": "IamListAccess",
                "Effect": "Allow",
                "Action": [
                    "iam:ListRoles",
                    "iam:ListUsers"
                ],
                "Resource": "*"
            }
        ]
    }
}
```

### You can also test API without downloading by sending POST request at https://remitlytask.azurewebsites.net/api/v1/verifyResources 
