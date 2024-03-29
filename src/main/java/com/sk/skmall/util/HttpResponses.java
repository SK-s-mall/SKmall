package com.sk.skmall.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpResponses {

    public static final ResponseEntity<HttpStatus> RESPONSE_OK = new ResponseEntity<>(HttpStatus.OK);
    public static final ResponseEntity<HttpStatus> RESPONSE_CREATED = new ResponseEntity<>(HttpStatus.CREATED);
    public static final ResponseEntity<HttpStatus> RESPONSE_BAD_REQUEST = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    public static final ResponseEntity<HttpStatus> RESPONSE_UNAUTHORIZED = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    public static final ResponseEntity<HttpStatus> RESPONSE_NOT_FOUND = new ResponseEntity<>(HttpStatus.NOT_FOUND);
    public static final ResponseEntity<HttpStatus> RESPONSE_CONFLICT = new ResponseEntity<>(HttpStatus.CONFLICT);
}
