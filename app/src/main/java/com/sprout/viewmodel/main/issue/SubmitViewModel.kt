package com.sprout.viewmodel.main.issue

import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.shop.net.repository.SproutRepository

class SubmitViewModel:BaseViewModel<SproutRepository>(Injection.repository) {
}