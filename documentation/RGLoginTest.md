### Test Design

### Requirements

Functional requirements [____]

###Test setup


| #  | user_role  |
|----|------------|
| 1  | scientist  |

### Test Scenario Positive

**RG-L-1** System provide an ability for authorized Users Log In

```gherkin
Given Authorized User Log In System
Then System show User Profile
```

**RG-L-2** System provide an ability for authorized Users to see his profile data

```gherkin
Given Authorized User Log In System
When User click on 'avatar'
Then User is able to see his name
    And user is able to see his list of jobs
```
**RG-L-3** System provide an ability for authorized Users to see his publication

```gherkin
Given Authorized User Log In System
When User click on 'avatar'
Then User is able to see his publications
```

