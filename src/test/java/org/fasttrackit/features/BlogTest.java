package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.steps.BlogSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class BlogTest extends BaseTest {
    @Steps
    private BlogSteps blogSteps;
//this is a line test 
    @Test
    public void addCommentToBlog() {
        String name = RandomStringUtils.randomAlphabetic(6);
        String comment = RandomStringUtils.randomAlphabetic(15);
        blogSteps.postComment(comment, name, "vladovidiubunea@gmail.com");
        blogSteps.findThePostedComment(name);
    }

    @Test
    public void tryToPostCommentWithoutName() {
        blogSteps.postComment("asac", "", "vladovidiubunea@gmail.com");
        blogSteps.errorNameAndEmailField("ERROR: please fill the required fields (name, email).");
    }

    @Test
    public void tryToPostCommentWithoutEmail() {
        blogSteps.postComment("asad", "vlad", "");
        blogSteps.errorNameAndEmailField("ERROR: please fill the required fields (name, email).");
    }

    @Test
    public void tryToPostCommentWithoutComment() {
        blogSteps.postComment("", "vlad", "vladovidiubunea@gmail.com");
        blogSteps.errorCommentField("ERROR: please type a comment.");

    }
}
