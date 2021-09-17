package com.project.mscomptes.business.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.mscomptes.model.Asset;
import com.project.mscomptes.model.OHLC;

@Service
public interface ApiService {

	List<OHLC> call(Asset asset) throws URISyntaxException, IOException;

}
