package com.kingenta.alipay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kingenta.alipay.dao.AlipayDao;
import com.kingenta.alipay.vo.AlipayCallRecord;

@Service
@Transactional
public class AlipayService {
	
	@Autowired private AlipayDao kfDicDao;
	
	public Integer saveAlipayCallRecord(AlipayCallRecord record) {
		return kfDicDao.saveAlipayCallRecord(record);
	}

}
