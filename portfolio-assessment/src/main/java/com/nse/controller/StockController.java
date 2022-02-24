package com.nse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nse.entity.Portfolio;
import com.nse.entity.Share;
import com.nse.service.StockService;

@RestController
public class StockController {

	@Autowired(required = true)
	StockService service;

	@RequestMapping("/createPortfolio")//localhost:8850/createPortfolio
	public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio p) {
		return new ResponseEntity<>(service.createPortfolio(p), HttpStatus.OK);
	}

	@RequestMapping("/createShare")//localhost:8850/createShare
	public ResponseEntity<Share> createShare(@RequestBody Share s) {
		return new ResponseEntity<>(service.createShare(s), HttpStatus.OK);
	}

	@RequestMapping("/buyShare/{shareId}/{portfolioId}")//localhost:8850/buyShare/{shareId}/{portfolioId}
	public boolean buyShare(@PathVariable Integer shareId, @PathVariable Integer portfolioId) {
		return service.buyShare(shareId, portfolioId);
	}

	@RequestMapping("/sellShare/{shareId}/{portfolioId}")//localhost:8850/sellShare/{shareId}/{portfolioId
	public boolean sellShare(@PathVariable Integer shareId, @PathVariable Integer portfolioId) {
		return service.sellShare(shareId, portfolioId);
	}

	@RequestMapping("/showPortfolio")//localhost:8850/showPortfolio
	public ResponseEntity<List<Portfolio>> showPortfolio() {
		return new ResponseEntity<>(service.showPortfolio(), HttpStatus.OK);
	}
}
