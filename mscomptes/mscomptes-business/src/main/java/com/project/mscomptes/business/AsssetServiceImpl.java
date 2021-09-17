package com.project.mscomptes.business;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mscomptes.business.api.ApiService;
import com.project.mscomptes.model.Asset;
import com.project.mscomptes.model.OHLC;
import com.project.mscomptes.persistance.AssetDao;
import com.project.mscomptes.technical.FileUtils;

@Service("assetService")
public class AsssetServiceImpl extends AbstractDatabaseService<Asset> implements AssetService {
	
	@Autowired
	AssetDao assetDao;
	
	@Autowired
	ApiService apiService;
	
	@Override
	public AssetDao getDao() {
		return assetDao;
	}
	
	@Override 
	@Transactional
	public void generateCsv() throws URISyntaxException, IOException {
		
		List<Asset> assets = findAll();
		List<OHLC> results = new ArrayList<OHLC>();

		// Get infos
		for (Asset asset : assets) {
			results.addAll(apiService.call(asset));	
		}
		
		// Write file
		writeFile(results);
	}
	
	private void writeFile(List<OHLC> results) {
		// S'il existe déja on le supprime
		FileUtils.removeFile("export.csv");
		
		for (OHLC ohlc : results) {
			FileUtils.writeOnFile("export.csv", ohlc.toString() + "\n");
		}
	}
}