package com.infogain.aspects;

public class ProductStockInHand extends Exception{
final String msg="Prouct already Sold out";

@Override
public String toString() {
	return "InvalidException [" + msg + "]";
}

}
