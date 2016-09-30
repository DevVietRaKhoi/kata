<?php

for($counter = 1; $counter <= 100; $counter++)
{
    if (0 == $counter % 3)
        echo 'Fizz<br>';
    if (0 == $counter % 5)
        echo 'Buzz<br>';
}
