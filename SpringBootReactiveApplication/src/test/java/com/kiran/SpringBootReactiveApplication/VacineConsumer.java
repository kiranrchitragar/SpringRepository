package com.kiran.SpringBootReactiveApplication;

import java.util.function.Consumer;

public class VacineConsumer implements Consumer<Vaccine> {

	@Override
	public void accept(Vaccine v) {

		System.out.println(v.getName());
		System.out.println(v.isDelivered());
	}

}
