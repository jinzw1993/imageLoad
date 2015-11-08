import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by zhiweijin on 15-11-7.
 */
public class Dakaji {


    public static void main(String[] arge) {
        Random random = new Random();
        List<PresonBean> personBeans = new ArrayList<PresonBean>();
        boolean[] booleans = new boolean[1000];
        personBeans.add(new PresonBean("1550511209", "李畅"));
        personBeans.add(new PresonBean("1550511205", "刘帅辰"));
        personBeans.add(new PresonBean("1550511209", "李畅"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh-MM-ss");
        Calendar C = Calendar.getInstance();
        int date = C.get(Calendar.DATE);
        System.out.println(date + "号");
        System.out.println(booleans[0] + "号");
        System.out.println(booleans[0] + "号");
        for (int i = date; i < 31; i++) {
            int week = C.get(Calendar.DAY_OF_WEEK);
            int shiweek = ((i - date + week) % 7) % 7;

            if (shiweek != 0 && shiweek != 1) {

                for (PresonBean pr : personBeans) {
                    {
                        int hh = random.nextInt(14) % 2 + 12;
                        String MM = random.nextInt(5) + "" + random.nextInt(9);
                        String SS = random.nextInt(5) + "" + random.nextInt(9);
                        do {

                            System.out.println(pr.getCode() + "\t" + "2015-11-" + i + " " + hh + ":" + MM + ":" + SS + "\t1\t1\t" + pr.getName() + "\tI\t0\t0");
                        } while (booleans[Integer.parseInt(MM)]);
                        booleans[Integer.parseInt(MM)] = true;
                    }

                    {
                        String MM = null;
                        int hh = random.nextInt(18) % 2 + 17;
                        if (hh == 17) {

                            MM = (random.nextInt(5) % 4 + 2) + "" + random.nextInt(9);
                        } else {
                            MM = random.nextInt(2) + "" + random.nextInt(9);
                        }

                        String SS = random.nextInt(5) + "" + random.nextInt(9);
                        do {
                            String a = "2015-11-" + i + " " + hh + ":" + MM + ":" + SS + pr.getCode();
                            System.out.println(pr.getCode() + "\t" + "2015-11-" + i + " " + hh + ":" + MM + ":" + SS + "\t1\t1\t" + pr.getName() + "\tI\t0\t0");
                        } while (booleans[Integer.parseInt(MM)]);
                        booleans[Integer.parseInt(MM)] = true;

                    }
                    {
                        String MM = null;

                        int hh = random.nextInt(22) % 2 + 20;
                        if (hh == 20) {

                            MM = random.nextInt(5) % 4 + 2 + "" + random.nextInt(9);
                        } else {

                            MM = random.nextInt(5) + "" + random.nextInt(9);
                        }

                        String SS = random.nextInt(5) + "" + random.nextInt(9);
                        do {

                            System.out.println(pr.getCode() + "\t" + "2015-11-" + i + " " + hh + ":" + MM + ":" + SS + "\t1\t1\t" + pr.getName() + "\tI\t0\t0");
                        } while (booleans[Integer.parseInt(MM)]);
                        booleans[Integer.parseInt(MM)] = true;

                    }
                }

                System.out.println();

            }

        }

    }

}
