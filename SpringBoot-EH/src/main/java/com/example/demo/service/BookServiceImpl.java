package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.NoBookFoundException;


@Service
public class BookServiceImpl implements BookService {

	@Override
	public Double findById(String bookId) {
		// TODO Auto-generated method stub

		if (bookId.equals("D101")) {
			return 450.00;
		} else {
			throw new NoBookFoundException("No Book Found With Given ID");
		}
	}

}
