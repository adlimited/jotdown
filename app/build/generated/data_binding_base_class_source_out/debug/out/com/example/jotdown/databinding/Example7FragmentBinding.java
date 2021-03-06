// Generated by view binder compiler. Do not edit!
package com.example.jotdown.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.jotdown.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.huawei.hms.ads.banner.BannerView;
import com.kizitonwose.calendarview.CalendarView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class Example7FragmentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FloatingActionButton add;

  @NonNull
  public final CalendarView exSevenCalendar;

  @NonNull
  public final BannerView hwBannerView;

  @NonNull
  public final TextView textView4;

  private Example7FragmentBinding(@NonNull ConstraintLayout rootView,
      @NonNull FloatingActionButton add, @NonNull CalendarView exSevenCalendar,
      @NonNull BannerView hwBannerView, @NonNull TextView textView4) {
    this.rootView = rootView;
    this.add = add;
    this.exSevenCalendar = exSevenCalendar;
    this.hwBannerView = hwBannerView;
    this.textView4 = textView4;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static Example7FragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static Example7FragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.example_7_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static Example7FragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add;
      FloatingActionButton add = ViewBindings.findChildViewById(rootView, id);
      if (add == null) {
        break missingId;
      }

      id = R.id.exSevenCalendar;
      CalendarView exSevenCalendar = ViewBindings.findChildViewById(rootView, id);
      if (exSevenCalendar == null) {
        break missingId;
      }

      id = R.id.hw_banner_view;
      BannerView hwBannerView = ViewBindings.findChildViewById(rootView, id);
      if (hwBannerView == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      return new Example7FragmentBinding((ConstraintLayout) rootView, add, exSevenCalendar,
          hwBannerView, textView4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
