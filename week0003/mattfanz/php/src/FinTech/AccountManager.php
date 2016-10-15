<?php
/*
 * This file is part of the FinTech.
 */

namespace FinTech;

/**
 * Class AccountManager
 * @package FinTech
 */
class AccountManager
{
    /**
     * Store Accounts
     * @var array
     */
    protected $accounts = [];

    /**
     * @param $name
     * @return string
     */
    protected function getKeyName($name)
    {
        return strtolower($name);
    }

    /**
     * @param $name
     * @return bool|mixed
     */
    protected function findOrFail($name)
    {
        $keyName = $this->getKeyName($name);
        if (array_key_exists($keyName, $this->accounts)) {
            return $this->accounts[$keyName];
        }
        return false;
    }

    /**
     * @param $name
     * @param $amount
     * @return bool
     */
    public function addAccount($name, $amount)
    {
        if (ctype_alpha($name) && !$this->findOrFail($name) && is_numeric($amount) && $amount > 0) {
            $newAccount = new Account($name, $amount);
            $this->accounts[$this->getKeyName($name)] = $newAccount;
            return true;
        }
        return false;
    }

    /**
     * @param $name
     * @param $amount
     * @return bool
     */
    public function depositMoney($name, $amount)
    {
        if ($account = $this->findOrFail($name)) {
            return $account->deposit($amount);
        }
        return false;
    }

    /**
     * @param $name
     * @param $amount
     * @return bool
     */
    public function withdrawMoney($name, $amount)
    {
        if ($account = $this->findOrFail($name)) {
            return $account->withdraw($amount);
        }
        return false;
    }
}
