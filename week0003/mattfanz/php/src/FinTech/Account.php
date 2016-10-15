<?php
/*
 * This file is part of the FinTech.
 */
namespace FinTech;

/**
 * Class Account
 * @package FinTech
 */
class Account
{
    /**
     * @var string
     */
    protected $name;

    /**
     * @var double
     */
    protected $amount = 0.00;

    /**
     * Account constructor.
     * @param $name
     * @param $amount
     */
    public function __construct($name, $amount)
    {
        $this->name = $name;
        $this->amount = (double) $amount;
    }

    /**
     * @param $amount
     * @return bool
     */
    public function deposit($amount)
    {
        if ($this->checkTransaction($amount)) {
            $this->amount += $amount;
            return true;
        }
        return false;
    }

    /**
     * @param $amount
     * @return bool
     */
    public function withdraw($amount)
    {
        if ($this->checkTransaction($amount) && $this->amount - $amount >= 0) {
            $this->amount -= $amount;
            return true;
        }
        return false;
    }

    /**
     * @param $amount
     * @return bool
     */
    protected function checkTransaction($amount)
    {
        return (is_numeric($amount) && $amount > 0);
    }
}
