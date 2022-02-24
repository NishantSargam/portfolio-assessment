package com.nse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nse.entity.Portfolio;
import com.nse.entity.Share;
import com.nse.repo.PortfolioRepo;
import com.nse.repo.ShareRepo;

@org.springframework.stereotype.Service
public class StockServiceImpl implements StockService {

	// repositories for share and portfolio
	@Autowired
	private PortfolioRepo pRepo;
	@Autowired
	private ShareRepo sRepo;

	// create and show portfolios
	public Portfolio createPortfolio(Portfolio p) {// creates a repository for class Portfolio
		return pRepo.save(p);
	}

	public List<Portfolio> showPortfolio() {// displays the portfolio entries
		return pRepo.findAll();
	}

	// create and show shares
	public Share createShare(Share s) {// creates a repository for class Share
		return sRepo.save(s);
	}

	public List<Share> showShare() {// displays the share entries
		return sRepo.findAll();
	}

	// method to buy shares
	public boolean buyShare(Integer shareId, Integer portfolioId) {
		Portfolio p = pRepo.findById(portfolioId).get();
		Share s = sRepo.findById(shareId).get();
		// investment addition
		p.setInvestment(p.getInvestment() + (s.getPrice() * s.getQuantity()));

		// add new objects to list
		List<Portfolio> plist = new ArrayList<>();
		plist.add(p);

		List<Share> slist = new ArrayList<>();
		slist.add(s);

		p.setShares(slist);
		s.setPortfolio(plist);
		// save elements in repositories
		pRepo.save(p);
		sRepo.save(s);

		return true;
	}

	public boolean sellShare(Integer shareId, Integer portfolioId) {

		Portfolio p = pRepo.findById(portfolioId).get();
		Share s = sRepo.findById(shareId).get();
		// investment deletion
		p.setInvestment(p.getInvestment() - (s.getPrice() * s.getQuantity()));

		List<Portfolio> plist = new ArrayList<>();
		plist.add(p);

		List<Share> slist = new ArrayList<>();
		slist.add(s);

		p.setShares(slist);
		s.setPortfolio(plist);
		// delete elements in repositories
		pRepo.delete(p);
		sRepo.delete(s);

		return true;
	}

}