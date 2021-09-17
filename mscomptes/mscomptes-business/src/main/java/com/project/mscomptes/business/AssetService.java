package com.project.mscomptes.business;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;

import com.project.mscomptes.model.Asset;

@Service
public interface AssetService extends DatabaseService<Asset> {

	void generateCsv() throws URISyntaxException, IOException;
}

