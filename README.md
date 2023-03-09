# aon-tasks

### Set up
- Project is built with gradle build tool. Example command:
```./gradlew build```
- Project is written in JDK17

### Task 1

- Part 1:
  - Code is in package `com.trungdo.task1`
  - A Metrics class is created which is used for timing method invocation. This class can be reused for measuring other classes, interfaces
  - TimedIncDec implements IncDec and it delegates the actual work to an implementation of InDec. Hence it can be used to measure MyIncDec or any other classes implementing IncDec
  - TimedIncDec calls Metrics method to measure method invocation
  - TimedIncDecRunner is an example of how to use TimedIncDec
  - Metrics class is not thread-safe

- Part 2:
  - A more scalable approach is to use Java instrumentation API such as a Java agent.
  - Instrumentation API allows ways to alter existing byte-code and hence can be used to measure method invocations and other functionalities
  - Example: [New Relic Java Agent
](https://docs.newrelic.com/docs/apm/agents/java-agent/getting-started/introduction-new-relic-java/)

### Task 2

The algorithm is to loop through the start index from 0 to (length of array 1 - length of array 2).
This will exclude the case in which array 2 is longer than array 1
For each start index, we check if this is the start index of matching sub array by looping through and comparing each element
If a non-matching element found, terminates early and continue to new start index
Once a matching sub array is found, return the result. Else return -1

Unit tests can be found in `Tas2Tests` class

### Task 3

Code review:
- Result of multiple might overflow if two integers are big enough
- This is a recursion (y times to be exact) which might cause stack overflow if y is too high
- Can use primitive type rather than Integer class for better performance
- Is it better to use existing multiply operator or BigInteger multiply in this case?

### Task 4

Code review:
- Collection classes should use generic type. E.g: `List<Insurer>`, `ArrayList<Insurer>`
- Better to return an interface type rather than an implementation class. i.e `List<T>` rather than `LinkedList<T>`. 
- No obvious reason to return LinkedList. LinkedList has slow access by index. This also removes unnecessary construction of new list. `new LinkedList(l)`
- `p2 == p`. Shouldn't use reference equality here as no guarantee they are same object. Compare by using equals method (if implemented for Policy) or by policy id
- The use of `getAllPolicies()` method looks wrong as its element type is `Insurer`. This looks like it should be `getAllInsurers()`
- debug is unused. Should be removed and shouldn't be in production code. Use LOG level if debug log is needed
- Once policy is found (found == true), should break out of the loop. 
- `list.get(0)` is wrong. Should be `list.get(i)`. Better yet, can use `for (Insurer insurer: list)` (provided we use generic type collection)
- The null check `insurer != null` should be done earlier in the code block if `null` value is possible
- The logic of finding if insurer has policy can be shortened with new Java syntax, like this:
  ```insurer.getPolicies().stream.anyMatch(policy -> policy.equals(p))```

### Task 5

A recent trend in software engineering is the adoption of cloud technology (e.g AWS, Azure, GCP). 
As part of this trend is the usage of **Infrastructure as code (IOC)** in which engineers can deploy infrastructures (RDS, data stream) using code (e.g Terraform)
This is increasingly popular over time as it speeds up the development to release time and bring CI/CD to further extent (in addition to other benefits)
As part of my work, I work across both legacy system which relies on manual deployment and modern system which adopts IOC. Thus, I can see the huge benefit of IOC and cloud adoption in general
To keep up with the trend, I actively learn cloud technologies (e.g AWS RDS, S3, Kinesis, SQS, ElastiCache, etc) as well as Terraform.

Other noteworthy trends: The use of AI in software development (e.g Github Copilot)

### Task 6

One of the project I worked on and delivered is the feature of *online identity verification* for loan applications.
Traditionally, after users apply for loans, they would need to have their identity verified at bank branches.
By introducing this feature we allow users to be able to verify themselves at the point of application.

One important aspect that made this feature so valuable to the user is to understand their pain point and the flow of the feature.
Due to the use of third-party verification tools, it was important that we understand how users would use the tools to fully leverage its value.
Another important aspect is a very thorough testing plan to make sure we cover all the use cases 

### Task 7

For me, one of my key principals, not just in software engineering but in overall professional and personal lives, is *to do things right, not just easy things*.
Doing things right will mean more testing, more work, more effort, but it will lead to better products, happier customers
