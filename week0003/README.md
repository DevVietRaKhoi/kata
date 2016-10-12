# Week 0003

This week we will have fun with I/O and build a simple query application. Make sure your code is extensible so we can reuse and expand in in the next week's problem set.

## FinTech 101

Now you have launched a new FinTech start-up that will shake grounds with its new and innovative retail baking system. The system and process the following commands via STDIN/STDOUT:

1. Add a new client

    ```
    A Name InitialAmount
    ```

    * `A` is the keyword, triggering an action to add
    * `Name` is the name of the client, only alphabetic characters allowed. It contains no spaces. Names are case-insensitive
    * `InitialAmount` is the amount of money (USD) at the time of account opening. It's a positive `double`
    * If the user attempts to add the same name again, reject

2. Deposit money

    ```
    D Name Amount
    ```

    * `D` is the keyword, triggering an action to deposit
    * `Name` is the name of the client, only alphabetic characters allowed. It contains no spaces. Names are case-insensitive
    * `Amount` is the amount of money (USD) to deposit. It's a positive `double`
    * Reject if the user attempts to deposit for an invalid client

3. Withdraw money

    ```
    W Name Amount
    ```

    * `W` is the keyword, triggering an action to withdraw
    * `Name` is the name of the client, only alphabetic characters allowed. It contains no spaces. Names are case-insensitive
    * `Amount` is the amount of money (USD) to withdraw. It's a positive `double`
    * Reject if the user attempts to withdraw from an invalid client
    * Reject if the user attempts to withdraw a larger amount than the actual amount of the client

4. Success/Failure handling

    * If an action/command was successful, print to STDOUT `True`, followed by a newline
    * If an action/command failed, print to STDOUT `False`, followed by a newline
    * If the amount is non-positive, print to STDOUT `False`, followed by a newline
    * Reject unrecognized keywords by printing to STDOUT `Invalid`, followed by a newline

## Submission

### Acceptance condition

* You must implement all required tasks
* Make sure to test against the provided test case `test_case_01.input` before submitting

Sample commands to test:

```
diff <(python week0003.py < test_case_01.input) test_case_01.output

diff <(php week0003.php < test_case_01.input) test_case_01.output

diff <(./week0003.exe < test_case_01.input) test_case_01.output

diff <(java week0003 < test_case_01.input) test_case_01.output

diff <(./week0003.sh < test_case_01.input) test_case_01.output
```

### Folder structure

Please structure your code like this:

* Have your own folder named after your GitHub ID
* Each language has own folder
* Keep the files named week0003/week0003.<language>

```
week0003/
  |--YourGitHubID/
     |--cpp/
        |--week0003.cpp
     |--php/
        |--week0003.php
     |--python/
        |--week0003.py
     |--ruby/
        |--week0003.rb
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
* OCaml
* Perl
* PHP
* Python
* Ruby
* Unix shells & tools: sh/ksh/bash/zsh, awk, sed, uniq, ...

You can submit by creating a pull request.

Please direct your ideas, suggestions, collaboration requests to: viet@code2.pro
