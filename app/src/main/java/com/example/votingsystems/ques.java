package com.example.votingsystems;

public class ques
{
    private String q;
    private String a;
    private String b;
    private String c;
    private String d;

    public ques(){}
    public ques(String q,String a,String b,String c,String d)
    {
        this.q=q;
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }

    public String getq()
    {
        return q;
    }
    public String geta()
    {
        return a;
    }
    public String getb()
    {
        return b;
    }
    public String getc()
    {
        return c;
    }
    public String getd()
    {
        return d;
    }
}