package com.example.GroupFitness;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.GroupFitness.controller.MemberController;

@SpringBootTest
class GroupFitnessApplicationTests {

	@Autowired
	private MemberController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
