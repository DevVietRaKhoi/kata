# Week 0004

This week you will be doing a basic sample interview question for an event management company. Aim to write efficient and reusable code.

## Event Guests

Now you are in event management business. You have 2 events taking place on the same day, at the same time. You noticed some guests registered for both events and want to notify them so they can pick either of the events.

1. Input

    ```
    fname,lname,email
    Bob,Dylan,bob.dylan@abc.com
    Bill,Gates,bill@xyz.com
    ...
    ```

    * There is 1 CSV file for each event
    * All CSV files contain valid data
    * Names and emails do not contain comma `,`
    * Names and emails are case-insensitive
    * Some highly esteemed guests have interesting names: O'Reilly, da Gama, van Derks, ...
    * All foreign names are transliterated to English. Don't worry about Vietnamese, Chinese or Russian ;)
    * One guest can have only one email

2. Output

    ```
    Bill Gates <bill@xyz.com>
    Bob Dylan <bob.dylan@abc.com>
    ...
    ```

    * Print to STDOUT
    * Print the guests who registered for both events in the format above
    * Note that there are no more `,` in the output and emails are wrapped in `<>`
    * Sort the guests by first name and then by the last name, and then by email

## Submission

### Acceptance condition

* The program must take files via `argv` (the order does not matter):

    ```
    ./week0004.py event1.input event2.input
    ./week0004.py event2.input event1.input
    ```

* Make sure to test against the provided test case `event1.input`, `event2.input` and the output `guests.output` before submitting

Sample commands to test:

```
diff <(python week0004.py event1.input event2.input) guests.output

diff <(php week0004.php event1.input event2.input) guests.output

diff <(./week0004.exe event1.input event2.input) guests.output

diff <(java week0004 event1.input event2.input) guests.output

diff <(./week0004.sh event1.input event2.input) guests.output
```

### Folder structure

Please structure your code like this:

* Have your own folder named after your GitHub ID
* Each language has own folder
* Keep the files named week0004/week0004.<language>

```
week0004/
  |--YourGitHubID/
     |--cpp/
        |--week0004.cpp
     |--php/
        |--week0004.php
     |--python/
        |--week0004.py
     |--ruby/
        |--week0004.rb
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
