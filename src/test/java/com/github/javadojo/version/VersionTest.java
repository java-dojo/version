package com.github.javadojo.version;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VersionTest {

    @Test(enabled = false)
    public void testParse() {
        Assert.assertNotNull(Version.parse("1"),
            "Expected a version to be created.");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, enabled = false)
    public void testParseFailed() {
        Version.parse("abc");
    }

    @Test(enabled = false)
    public void testToString() {
        Version v = Version.parse("1");
        Assert.assertNotNull(v.toString(),
            "Expected a String of the version to be created.");
    }

    @Test(enabled = false)
    public void testToStringEqualsNewVersion() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse(v1.toString());
        Assert.assertEquals(v2, v1,
            "Expected the version from toString to be equal to the newly " +
                "parsed version.");
    }

    @Test(enabled = false)
    public void testToStringHashCode() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse(v1.toString());
        Assert.assertEquals(v2.hashCode(), v1.hashCode(),
            "Expected the hash codes to be equal.");
    }

    @Test(enabled = false)
    public void testEqualsIgnoresMinor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("1.0.0");
        Assert.assertEquals(v2, v1,
            "Expected the version \"1\" to be equal to \"1.0.0\".");
    }


    @Test(enabled = false)
    public void testHashCodeIgnoresMinor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("1.0.0");
        Assert.assertEquals(v2.hashCode(), v1.hashCode(),
            "Expected the hash codes of version \"1\" and \"1.0.0\" to be " +
                "equal.");
    }

    @Test(enabled = false)
    public void testEqualsRespectedMinor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("1.1.0");
        Assert.assertNotEquals(v2, v1,
            "Expected the version \"1\" not to be equal to \"1.1.0\".");
    }

    @Test(enabled = false)
    public void testHashCodeRespectedMinor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("1.1.0");
        Assert.assertNotEquals(v2, v1,
            "Expected the hash codes of version \"1\" and \"1.1.0\" not to " +
                "be equal.");
    }

    @Test(enabled = false)
    public void testEqualsRespectedBugFix() {
        Version v1 = Version.parse("1.2.3");
        Version v2 = Version.parse("1.2.3");
        Assert.assertEquals(v1, v2, "Expected the versions to be equal.");
    }

    @Test(enabled = false)
    public void testHashCode() {
        Version v1 = Version.parse("1.2.3");
        Version v2 = Version.parse("1.2.3");
        Assert.assertEquals(v1.hashCode(), v2.hashCode(),
            "Expected the hash codes to be equal.");
    }

    @Test(enabled = false)
    public void testComparesToIgnoresMinor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("1.0.0");
        Assert.assertTrue(v2.compareTo(v1) == 0,
            "Expected the version \"1\" to be equal to \"1.0.0\".");
    }

    @Test(enabled = false)
    public void testComparesEqualMajor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("1");
        Assert.assertTrue(v1.compareTo(v2) == 0,
            "Expected the version \"1\" to be equal than \"1\".");
    }

    @Test(enabled = false)
    public void testComparesLessMajor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("2");
        Assert.assertTrue(v1.compareTo(v2) < 0,
            "Expected the version \"1\" to be less than \"2\".");
    }

    @Test(enabled = false)
    public void testComparesGreaterMajor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("2");
        Assert.assertTrue(v2.compareTo(v1) > 0,
            "Expected the version \"2\" to be greater than \"1\".");
    }

    @Test(enabled = false)
    public void testComparesEqualMinor() {
        Version v1 = Version.parse("1.1");
        Version v2 = Version.parse("1.1");
        Assert.assertTrue(v1.compareTo(v2) == 0,
            "Expected the version \"1.1\" to be equal to \"1.1\".");
    }

    @Test(enabled = false)
    public void testComparesLessMinor() {
        Version v1 = Version.parse("1.1");
        Version v2 = Version.parse("1.2");
        Assert.assertTrue(v1.compareTo(v2) < 0,
            "Expected the version \"1.1\" to be less than \"1.2\".");
    }

    @Test(enabled = false)
    public void testComparesGreaterMinor() {
        Version v1 = Version.parse("1.1");
        Version v2 = Version.parse("1.2");
        Assert.assertTrue(v2.compareTo(v1) > 0,
            "Expected the version \"1.2\" to be greater than \"1.1\".");
    }

    @Test(enabled = false)
    public void testComparesEqualBugfix() {
        Version v1 = Version.parse("1.1.1");
        Version v2 = Version.parse("1.1.1");
        Assert.assertTrue(v1.compareTo(v2) == 0,
            "Expected the version \"1.1.1\" to be equal to \"1.1.1\".");
    }

    @Test(enabled = false)
    public void testComparesLessBugfix() {
        Version v1 = Version.parse("1.1.1");
        Version v2 = Version.parse("1.1.2");
        Assert.assertTrue(v1.compareTo(v2) < 0,
            "Expected the version \"1.1.1\" to be less than \"1.1.2\".");
    }

    @Test(enabled = false)
    public void testComparesGreaterBugfix() {
        Version v1 = Version.parse("1.1.1");
        Version v2 = Version.parse("1.1.2");
        Assert.assertTrue(v2.compareTo(v1) > 0,
            "Expected the version \"1.1.2\" to be greater than \"1.1.1\".");
    }

}
