<?php

if (! function_exists('printFizzBuzz')) {
    function printFizzBuzz($begin, $end, $requirementData) {
        if ($begin > $end) {
            throw new Exception('Begin number cannot greater than end number');
        }
        for ($i = $begin; $i <= $end; $i++) {
            foreach ($requirementData as $numberDivided => $stringEcho) {
                if ($i % $numberDivided == 0) {
                    echo $stringEcho . '</br>';
                }
            }
        }
    }
}

$requirementData = [
    '3' => 'Fizz',
    '5' => 'Buzz'
];
printFizzBuzz(1, 100, $requirementData);
