package Bishi;

import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 读取测试数据组数

        while (T-- > 0) {
            String timeStr = scanner.next();
            int hour = Integer.parseInt(timeStr.substring(0, 2));
            int minute = Integer.parseInt(timeStr.substring(3, 5));

            // 减去8小时得到UTC时间
            int utcHour = (hour - 8 + 24) % 24;

            // 格式化输出
            System.out.printf("%02d:%02d\n", utcHour, minute);
        }

        scanner.close();
    }
}
