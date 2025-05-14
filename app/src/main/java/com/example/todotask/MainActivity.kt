override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    	menuInflater.inflate(R.menu.menu_main, menu)
    	val searchItem = menu?.findItem(R.id.action_search)
    	val searchView = searchItem?.actionView as? SearchView
    	searchView?.queryHint = "ابحث عن مهمة..."
    	searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        	override fun onQueryTextSubmit(query: String?): Boolean = false
        	override fun onQueryTextChange(newText: String?): Boolean {
            	// فلترة محلية بسيطة
            	newText?.let { text ->
                	viewModel.tasks.value?.let { list ->
                    	val filtered = list.filter { it.title.contains(text, true) }
                    	findViewById<RecyclerView>(R.id.tasksRecyclerView).adapter =
                        	TaskAdapter(filtered)
                	}
            	}
            	return true
        	}
    	})
    	return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
    	return when (item.itemId) {
        	R.id.action_settings -> {
            	startActivity(Intent(this, SettingsActivity::class.java))
            	true
        	}
        	else -> super.onOptionsItemSelected(item)
    	}
	}

}
