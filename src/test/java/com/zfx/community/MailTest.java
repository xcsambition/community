package com.zfx.community;

import com.zfx.community.utils.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author zfx
 * @date 2022/4/4 00:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTest {
    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
//        String to = "1633697855@qq.com";
        String to = "xcsambition@sina.com";
        mailClient.sendMail(to, "demo_text", "主要内容demo");
    }

    @Test
    public void testHtmlMail() {
        String to = "1633697855@qq.com";
        Context context = new Context();
        context.setVariable("username", "BumBleBee");
        String content = templateEngine.process("/mail/demo", context);
        mailClient.sendMail(to, "demo_Html", content);

    }

    @Test
    public void test() {
//        int[] nums = new int[3];
//        for (int i : nums) {
//            i = 0;
//        }
//        Scanner scanner = new Scanner(System.in);
//        int tartget = scanner.nextInt();
//        dfs(nums, tartget);
//        System.out.println("x = " + nums[0]);
//        System.out.println("y = " + nums[1]);
//        System.out.println("z = " + nums[2]);

        for (long x = 0; x < 1001; x++) {
            for (int y = 0; y < 1001; y++) {
                for (int z = 0; z < 1001; z++) {
                    if (((5 * x + 6) * y + 6) * z == 22l){
                        System.out.println("x:"+x+"y:"+y+"z:"+z);

                    }
                }
            }
        }
    }

//    private void dfs(int[] nums, int sum, int target) {
//
//        if (sum == target) {
//            return;
//        }
//        for (int i = 0; i < 3; i++) {
//            nums[0]
//
//        }
//    }


}
