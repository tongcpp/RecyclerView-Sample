package com.example.recyclerview;

import com.example.recyclerview.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerAdapter extends Adapter<RecyclerAdapter.ViewHolder> {
	private String[] mDataset;
	private Context mContext;

	public RecyclerAdapter(String[] dataset, Context context) {
		mDataset = dataset;
		mContext = context;
	}

	// 是否使用static修饰
	// 是 - 嵌套类 开销更小
	// 否 - 内部类 可获取外部类非静态成员
	public class ViewHolder extends RecyclerView.ViewHolder {

		public TextView mTextView;

		public ViewHolder(View itemView) {
			super(itemView);
			mTextView = (TextView) itemView.findViewById(R.id.text);
			itemView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(
							mContext,
							"点击 - " + getPosition() + " - "
									+ mTextView.getText().toString() + " - "
									+ mDataset[getPosition()], 0).show();
				}
			});
		}
	}

	@Override
	public int getItemCount() {
		return mDataset.length;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.mTextView.setText(mDataset[position]);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// View view = View.inflate(parent.getContext(),
		// android.R.layout.simple_list_item_1, null);
		// View view = View.inflate(mContext, R.layout.recycle_item, null);
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//				(LayoutInflater) mContext
//				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.recycle_item, parent, false);

		ViewHolder holder = new ViewHolder(view);
		return holder;
	}
}
