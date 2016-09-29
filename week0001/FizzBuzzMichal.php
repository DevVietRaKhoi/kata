<?php

for($counter = 1; $counter <= 100; $counter++)
{
    echo 0 == $counter%3 ? 'Fizz<br>' : '';
    echo 0 == $counter%5 ? 'Buzz<br>' : '';
}
