package com.tippingcanoe.scratch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ScratchAdapter extends RecyclerView.Adapter<ScratchAdapter.ScratchViewHolder> {
	List<String> sentances;
	List<String> words;

	public ScratchAdapter () {
		sentances = getRandomSentances(100, -1);
		words = getRandomSentances(100, 1);
	}

	@Override
	public ScratchViewHolder onCreateViewHolder ( ViewGroup viewGroup, int i ) {
		View view = LayoutInflater.from(viewGroup.getContext())
		                       .inflate(R.layout.scratch_view, viewGroup, false);
		return new ScratchViewHolder(view);
	}

	@Override
	public void onBindViewHolder ( ScratchViewHolder scratchViewHolder, int i ) {
		scratchViewHolder.textView.setText(sentances.get(i));
		scratchViewHolder.textView2.setText("I don't work: " + words.get(i));
		scratchViewHolder.textView3.setText("wrap_content: " + words.get(i));
		scratchViewHolder.textView4.setText("I work: " + words.get(i));
		scratchViewHolder.textView5.setText("Fixed height: " + words.get(i));
	}

	@Override
	public int getItemCount () {
		return sentances.size();
	}

	protected List<String> getRandomSentances (int numSentances, int wordsInSentance) {
		ArrayList<String> words = new ArrayList<String>(Arrays.asList("lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit", "curabitur", "vel", "hendrerit", "libero", "eleifend", "blandit", "nunc", "ornare", "odio", "ut", "orci", "gravida", "imperdiet", "nullam", "purus", "lacinia", "a", "pretium", "quis", "congue", "praesent", "sagittis", "laoreet", "auctor", "mauris", "non", "velit", "eros", "dictum", "proin", "accumsan", "sapien", "nec", "massa", "volutpat", "venenatis", "sed", "eu", "molestie", "lacus", "quisque", "porttitor", "ligula", "dui", "mollis", "tempus", "at", "magna", "vestibulum", "turpis", "ac", "diam", "tincidunt", "id", "condimentum", "enim", "sodales", "in", "hac", "habitasse", "platea", "dictumst", "aenean", "neque", "fusce", "augue", "leo", "eget", "semper", "mattis", "tortor", "scelerisque", "nulla", "interdum", "tellus", "malesuada", "rhoncus", "porta", "sem", "aliquet", "et", "nam", "suspendisse", "potenti", "vivamus", "luctus", "fringilla", "erat", "donec", "justo", "vehicula", "ultricies", "varius", "ante", "primis", "faucibus", "ultrices", "posuere", "cubilia", "curae", "etiam", "cursus", "aliquam", "quam", "dapibus", "nisl", "feugiat", "egestas", "class", "aptent", "taciti", "sociosqu", "ad", "litora", "torquent", "per", "conubia", "nostra", "inceptos", "himenaeos", "phasellus", "nibh", "pulvinar", "vitae", "urna", "iaculis", "lobortis", "nisi", "viverra", "arcu", "morbi", "pellentesque", "metus", "commodo", "ut", "facilisis", "felis", "tristique", "ullamcorper", "placerat", "aenean", "convallis", "sollicitudin", "integer", "rutrum", "duis", "est", "etiam", "bibendum", "donec", "pharetra", "vulputate", "maecenas", "mi", "fermentum", "consequat", "suscipit", "aliquam", "habitant", "senectus", "netus", "fames", "quisque", "euismod", "curabitur", "lectus", "elementum", "tempor", "risus", "cras"));
		List<String> sentances = new ArrayList<String>();

		Random random = new Random();
		final int LOW = 1;
		final int HIGH = 10;

		for (int i = 0; i <= numSentances; i++) {
			String sentance = "";

			int wordsInCurrentSentance = wordsInSentance == -1 ? random.nextInt(HIGH - LOW) + LOW : wordsInSentance;

			for (int j = 0; j <= wordsInCurrentSentance; j++) {
				sentance += words.get(random.nextInt(words.size() - 1)) + " ";
			}

			sentances.add(sentance);
		}

		return sentances;
	}

	protected class ScratchViewHolder extends RecyclerView.ViewHolder {
		TextView textView;
		TextView textView2;
		TextView textView3;
		TextView textView4;
		TextView textView5;

		public ScratchViewHolder(View view) {
			super(view);

			textView = (TextView) view.findViewById(R.id.textView);
			textView2 = (TextView) view.findViewById(R.id.textView2);
			textView3 = (TextView) view.findViewById(R.id.textView3);
			textView4 = (TextView) view.findViewById(R.id.textView4);
			textView5 = (TextView) view.findViewById(R.id.textView5);
		}
	}
}
