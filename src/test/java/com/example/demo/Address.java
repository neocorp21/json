package com.example.demo;

import java.io.Serializable;

public class Address  implements Serializable{
String street;


public Address() {
	super();
}

public Address(String street) {
	super();
	this.street = street;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

@Override
public String toString() {
	return "Address [street=" + street + "]";
}


}
