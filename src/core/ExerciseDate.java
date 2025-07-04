package core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExerciseDate {

    /**
     * calculate days between two dates.
     * @param startDate
     * @param endDate
     * @return
     */
    public long calculateDays(Date startDate, Date endDate) throws ParseException {

        long startTime = startDate.getTime() ;
        long endTime = endDate.getTime();
        long startDay = (long) Math.floor(startTime / (1000*60*60*24));
        long endDay = (long) Math.floor(endTime / (1000*60*60*24));
        long days = endDay - startDay;

        return days;
    }

    /**
     * Calculate Stages.
     * @param startDate
     */
    public void calculateStages(Date startDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(Calendar.DATE, 13);
        System.out.println("Calculating stages...\n");
        System.out.println("Stage 1 -> ");
        System.out.println("    End of stage 1 : " + formatter.format(c.getTime()));
        System.out.println("Stage 2 -> ");
        System.out.println("    Start of stage 2 : " + formatter.format(c.getTime()));
        c.add(Calendar.DATE, 28);
        System.out.println("    End of stage 2   : " + formatter.format(c.getTime()));
        System.out.println("Stage 3 -> ");
        System.out.println("    Start of stage 3 : " + formatter.format(c.getTime()));
        c.add(Calendar.DATE, 14);
        System.out.println("    End of stage 3   : " + formatter.format(c.getTime()));

    }
}
