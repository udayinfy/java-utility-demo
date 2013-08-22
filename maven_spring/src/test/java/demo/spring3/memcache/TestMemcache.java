package demo.spring3.memcache;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.CASMutation;
import net.spy.memcached.CASMutator;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.ConnectionFactoryBuilder.Protocol;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.auth.PlainCallbackHandler;
import net.spy.memcached.transcoders.IntegerTranscoder;
import net.spy.memcached.transcoders.SerializingTranscoder;
import net.spy.memcached.transcoders.Transcoder;

import org.junit.Test;

public class TestMemcache {

	@Test
	public void testGet() throws IOException {
		MemcachedClient c = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));

		String astr = "astring";
		// Store a value (async) for one hour
		c.set("astr", 3600, astr);
		// Retrieve a value (synchronously).
		Object astrObj = c.get("astr");
		System.out.println(astrObj);

		List<String> alist = new ArrayList<String>();
		alist.add("item1");
		alist.add("item2");
		alist.add("item3");
		c.set("alist", 3600, alist);
		Object alistObj = c.get("alist");
		System.out.println(alistObj);

	}

	@Test
	public void testasyncGet() throws IOException, InterruptedException, ExecutionException {
		// Get a memcached client connected to several servers
		MemcachedClient c = new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211 127.0.0.1:11211"));

		// Try to get a value, for up to 5 seconds, and cancel if it doesn't
		// return
		Object myObj = null;
		Future<Object> f = c.asyncGet("astr");
		try {
			myObj = f.get(5, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			// Since we don't need this, go ahead and cancel the operation. This
			// is not strictly necessary, but it'll save some work on the
			// server.
			f.cancel(false);
			// Do other timeout related stuff
		}
		System.out.println(myObj);
	}

	public void testestablishBinaryProtocolConnection() {

		MemcachedClient mc = null;

		// Create an AuthDescriptor, this one is for plain SASL, so the
		// username and passwords are just Strings
		AuthDescriptor ad = new AuthDescriptor(new String[] { "PLAIN" }, new PlainCallbackHandler("ausername",
				"apassword"));

		// Then connect using the ConnectionFactoryBuilder. Binary is required.
		try {
			if (mc == null) {
				mc = new MemcachedClient(new ConnectionFactoryBuilder().setProtocol(Protocol.BINARY)
						.setAuthDescriptor(ad).build(), AddrUtil.getAddresses("ahost"));
			}
		} catch (IOException ex) {
			System.err.println("Couldn't create a connection, bailing out: \nIOException " + ex.getMessage());
		}

	}

	/**
	 *  The low-level CAS operation is a bit difficult to get right, so I've provided an abstraction that will allow one to more easily use it.
	 *	Here's an example of how you might write a function that maintains a list of the 10 most recent Items using CAS (where Item is some kind of object that is meaningful within your application). Every call to addAnItem will place the new Item at the beginning of a List and store it (using CAS) in memcached.
	 *	The important part to focus on here is the interaction between the "mutation" (a functional construct that describes how to transform an existing value into the desired one) and the client.
	 *	Essentially, you only have to think of two things:
	 *	What do I do if there's no value under the key (initialize).
	 *	How do I want to manipulate an existing value if I find one?
	 *	Note that the mutation may occur multiple times (up to 8,192 by default) when there's contention. In general, you shouldn't care about the retries and just think about what you want to do when you find a value you like.
	 * @return
	 * @throws Exception
	 */
	@Test
	public void testaddAnItem() throws Exception {

		MemcachedClient client = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));

		final Item newItem = new Item();
		newItem.setId(1);
		newItem.setName("aname");

		// This is how we modify a list when we find one in the cache.
		CASMutation<List<Item>> mutation = new CASMutation<List<Item>>() {

			// This is only invoked when a value actually exists.
			public List<Item> getNewValue(List<Item> current) {
				// Not strictly necessary if you specify the storage as
				// LinkedList (our initial value isn't), but I like to keep
				// things functional anyway, so I'm going to copy this list
				// first.
				LinkedList<Item> ll = new LinkedList<Item>(current);

				// If the list is already "full", pop one off the end.
				if (ll.size() > 10) {
					ll.removeLast();
				}
				// Add mine first.
				ll.addFirst(newItem);

				return ll;
			}

		};

//		// The initial value -- only used when there's no list stored under
//		// the key.
//		List<Item> initialValue = Collections.singletonList(newItem);
//		Transcoder<List<Item>> transcoder = SerializingTranscoder();
//		// The mutator who'll do all the low-level stuff.
//		CASMutator<List<Item>> mutator = new CASMutator<List<Item>>(client, transcoder);
//
//		// This returns whatever value was successfully stored within the
//		// cache -- either the initial list as above, or a mutated existing
//		// one
//		System.out.println(retList);
//		List<Item> retList = mutator.cas("akey", initialValue, 0, mutation);
	}

	class Item implements Serializable{
		private static final long serialVersionUID = 5289430025612392826L;
		private int id;
		private String name;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}

}
