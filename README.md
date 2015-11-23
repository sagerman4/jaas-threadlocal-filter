# jaas-threadlocal-filter

So, I found myself saying, Sager, wouldn't it be nice if you could just grab the JAAS principal from some magical, floating object throughout your webapp without having to access request-level information from random pojos?

Why, yes; yes that would be nice, Sager.

So, I wrote something to do just that.

This is a servlet filter that just grabs the JAAS principal off of the incoming request and adds it to a ThreadLocal variable so you can grab her whenever you want.

Simple as that.

I'll update this readme with usage when I've actually built the damn thing.
