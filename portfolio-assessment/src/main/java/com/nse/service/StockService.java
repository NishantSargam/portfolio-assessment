package com.nse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.nse.entity.Portfolio;
import com.nse.entity.Share;

@org.springframework.stereotype.Service
public interface StockService {
	// interface for Stock Service Implementations
	// create object instances for each portfolio and share entry
	public Portfolio createPortfolio(Portfolio p);
	public Share createShare(Share s);

	// Lists for showShare and showPortfolio
	public List<Portfolio> showPortfolio();
	public List<Share> showShare();

	// buy and sell functions for Shares
	public boolean buyShare(Integer shareId, Integer portfolioId);
	public boolean sellShare(Integer shareId, Integer portfolioId);
}
