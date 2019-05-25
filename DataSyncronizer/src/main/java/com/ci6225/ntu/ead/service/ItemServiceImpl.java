package com.ci6225.ntu.ead.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci6225.ntu.ead.dao.ExpiredItemRepository;
import com.ci6225.ntu.ead.dao.ItemDetailsRepository;
import com.ci6225.ntu.ead.model.ExpiredItem;
import com.ci6225.ntu.ead.model.ItemDetails;

@Service
public class ItemServiceImpl implements ItemService {

    
    @Autowired
    ExpiredItemRepository expiredItemepository;
    @Autowired
    ItemDetailsRepository itemDetailsRepository;

    
    ExpiredItem expiredItem = new ExpiredItem();

    /*
     * (non-Javadoc)
     * @see com.ci6225.ntu.ead.service.ItemService#syncDbDetails()
     */
    public void syncDbDetails() {
    	
        System.out.println("Items have been added : " + itemDetailsRepository.findAll());
        
        for(ItemDetails itemDetails : itemDetailsRepository.findAll()) {
        	expiredItem.setItemId(itemDetails.getItemId());
        	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        	Date date = new Date();
        	System.out.println(dateFormat.format(date));
        	String[] dateToday = dateFormat.format(date).split("/");
        	int part1 = Integer.parseInt(dateToday[0]);
        	int part2 = Integer.parseInt(dateToday[1]);
        	int part3 = Integer.parseInt(dateToday[2]);
        	
        	if(itemDetails.getExpireDate() != null ) {
        		
        	String[] expireDate = itemDetails.getExpireDate().split("/");
        	int expireDate1 = Integer.parseInt(expireDate[0]);
        	int expireDate2 = Integer.parseInt(expireDate[1]);
        	int expireDate3 = Integer.parseInt(expireDate[2]);
        	
        	expiredItem.setExpiredDate(itemDetails.getExpireDate());
        	expiredItem.setUpdateDate(dateFormat.format(date));
        	expiredItem.setUpdateBy("SYSTEM");
        	expiredItem.setCategory(itemDetails.getCategory());
        	if((part1+part2+part3 >= expireDate1+expireDate2+expireDate3))
        	{
        	expiredItemepository.save(expiredItem);
        	System.out.println("expiredItemepository: " + expiredItem.getItemId());
        	
        	itemDetails.setStatus("expired");
        	itemDetailsRepository.save(itemDetails);
        	}
        	}
        	
        	System.out.println("itemDetailsRepository: " + itemDetails.getName());
        }

    }
}
