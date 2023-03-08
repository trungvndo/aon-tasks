# aon-tasks

### Task 1

- Part 1:
  - Code is in package com.trungdo.task1
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

### Task 3

Code review:
- Result of multiple might overflow if two integers are big enough
- This is a recursion (y times to be exact) which might cause stack overflow
- Can use primitive type rather than Integer class

### Task 4

- Collection classes should be generic type. E.g: `List<Insurer>`, `ArrayList<Insurer>`
- Better to return an interface type rather than an implementation class. i.e `List<T>` rather than LinkedList<T>. No obvious reason to return LinkedList. LinkedList has slow access by index. This also removes unnecessary construction of new list. `new LinkedList(l)`
- `p2 == p`. Shouldn't use reference equality here as no guarantee they are same object. Compare by using equals method (if implemented for Policy) or by policy id
- The use of `getAllPolicies()` method looks wrong as its element is insurer. This looks like it should be `getAllInsurers()`
- debug is unused. Should be removed
- Once policy is found (found == true), should break out of the loop. 
- `list.get(0)` is wrong. Should be `list.get(i)`. Better yet, can use `for (Insurer insurer: list)` (provided we use generic type collection)
- The null check `insurer != null` should be done earlier if `null` value is possible
- The logic of finding if insurer has policy can be shortened with new Java syntax.
  ```insurer.getPolicies().stream.anyMatch(policy -> policy.equals(p))```
