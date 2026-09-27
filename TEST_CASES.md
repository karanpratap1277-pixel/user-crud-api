# User CRUD API - Test Cases

| Test Case ID | API | Method | Test Scenario | Expected Result | Actual Result | Status |
|---|---|---|---|---|---|---|
| TC01 | /users | POST | Create user with valid data | User should be created successfully | User created successfully | PASS |
| TC02 | /users | GET | Get all users | All users should be returned | Users returned successfully | PASS |
| TC03 | /users/1 | GET | Get user by ID | User with given ID should be returned | User returned successfully | PASS |
| TC04 | /users/1 | PUT | Update existing user | User details should be updated | User updated successfully | PASS |
| TC05 | /users/1 | DELETE | Delete existing user | User should be deleted | User deleted successfully | PASS |
| TC06 | /users | POST | Create user with blank name | Request should be rejected | 400 Bad Request | PASS |
| TC07 | /users | POST | Create user with invalid email | Request should be rejected | 400 Bad Request | PASS |
| TC08 | /users | POST | Create user with invalid mobile number | Request should be rejected | 400 Bad Request | PASS |

## JUnit Test Results

The following unit tests were executed successfully:

- testCreateUser() - PASS
- testGetAllUsers() - PASS
- testGetUserById() - PASS
- testUpdateUser() - PASS
- testDeleteUser() - PASS

Total Unit Tests: 5  
Passed: 5  
Failed: 0