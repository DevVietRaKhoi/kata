# Week 0002

This week we will practice loops and basic printing to STDOUT. You are encouraged to provide parameters for your function.

## Spiral

Write a piece of code that does the following:

1. Prints a square of nicely arranged numbers, that run from 1 to 16 and resemble a spiral in clock-wise direction.

    ```
     1  2  3  4
    12 13 14  5
    11 16 15  6
    10  9  8  7
    ```

2. Extra: Provide an integer parameter N to create a spiral from numbers 1 to N*N (N >= 1)
3. Extra: Provide integer parameters M (number of rows) & N (number of columns) to create a spiral from numbers 1 to M*N (M >= 1 and N >= 1)

## Submission

### Acceptance condition

* You must solve at least requirement `1.`
* Feel free to solve `2.` and `3.` if you fancy
* Make sure to test against the provided test case `test_case_01.dat` before submitting

Sample command to test:

```
diff <(python week0002.py) test_case_01.dat
```

### Folder structure

Please structure your code like this:

* Have your own folder named after your GitHub ID
* Each language has own folder
* Keep the files named week0002/Week0002.<language>

```
week0002/
  |--YourGitHubID/
     |--php/
        |--week0002.php
     |--cpp/
        |--week0002.cpp
     |--python/
        |--week0002.py
     |--ruby/
        |--week0002.rb
```

### To PHP fans

* If you want your submission accepted, please do not use `<br/>` and `echo`
* You must use `php://stdin` & `php://stdout`!
* For your reading pleasure: http://php.net/manual/en/features.commandline.io-streams.php

### Languages

Submit your code in any of the following languages:

* C
* C#
* C++
* Go
* Java
* Javascript (browser/Node.JS)
* Objective-C
* OCaml
* Perl
* PHP
* Python
* Ruby
* Swift
* Unix shells & tools: sh/ksh/bash/zsh, awk, sed, uniq, ...

You can submit by creating a pull request.

Please direct your ideas, suggestions, collaboration requests to: viet@code2.pro
