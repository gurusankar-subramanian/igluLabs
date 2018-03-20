package com.jwt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import com.jwt.domain.Tasks;

/**
 * Common utility file 
 * @author Guru Sankar
 *
 */
@Component
public class CommonUtil {

	public static Boolean validateStartAndEndDateTime(Tasks task){
		if(task.getStartDateTimestamp().after(task.getEndDateTimestamp()))
			return false;
		else
			return true;
	}
	
	public static Boolean validateDate(Tasks task){
		Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);
            date = sdf.parse(task.getDate());
            if (!task.getDate().equals(sdf.format(date))) {
                date = null;
            }
            return true;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return false;
        }
    }
	
}
