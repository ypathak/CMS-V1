package com.commons.service;

import java.io.Serializable;
import org.springframework.stereotype.Service;
import com.commons.utils.ApplicationConstants;
import org.apache.log4j.Logger;

@Service
public abstract class AbstractService implements Serializable,ApplicationConstants{
	
	private static final long serialVersionUID = -4867222730047983728L;
	
	protected final Logger logger = Logger.getLogger(LOGGER_NAME);

}
